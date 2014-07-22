package nxt;

import nxt.crypto.EncryptedData;
import nxt.util.Convert;
import org.json.simple.JSONObject;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface Appendix {

    int getSize();
    byte[] getBytes();
    JSONObject getJSONObject();

    public static class Message implements Appendix {

        static Message parse(JSONObject attachmentData) throws NxtException.ValidationException {
            if (attachmentData.get("message") == null) {
                return null;
            }
            return new Message(attachmentData);
        }

        private final byte[] message;
        private final boolean isText;

        Message(ByteBuffer buffer) throws NxtException.ValidationException {
            int messageLength = buffer.getInt();
            this.isText = messageLength < 0; // ugly hack
            if (messageLength < 0) {
                if (Nxt.getBlockchain().getHeight() < Constants.DIGITAL_GOODS_STORE_BLOCK) {
                    throw new TransactionType.NotYetEnabledException("Text messages not yet enabled");
                }
                messageLength ^= Integer.MIN_VALUE;
            }
            if (messageLength > Constants.MAX_ARBITRARY_MESSAGE_LENGTH) {
                throw new NxtException.ValidationException("Invalid arbitrary message length: " + messageLength);
            }
            this.message = new byte[messageLength];
            buffer.get(this.message);
        }

        Message(JSONObject attachmentData) throws NxtException.ValidationException {
            String messageString = (String)attachmentData.get("message");
            this.isText = Boolean.TRUE.equals((Boolean)attachmentData.get("messageIsText"));
            if (this.isText && Nxt.getBlockchain().getHeight() < Constants.DIGITAL_GOODS_STORE_BLOCK) {
                throw new TransactionType.NotYetEnabledException("Text messages not yet enabled");
            }
            this.message = isText ? Convert.toBytes(messageString) : Convert.parseHexString(messageString);
            if (message.length > Constants.MAX_ARBITRARY_MESSAGE_LENGTH) {
                throw new NxtException.ValidationException("Invalid arbitrary message length: " + message.length);
            }
        }

        public Message(byte[] message) {
            this.message = message;
            this.isText = false;
        }

        public Message(String string) {
            this.message = Convert.toBytes(string);
            this.isText = true;
        }

        @Override
        public int getSize() {
            return 4 + message.length;
        }

        @Override
        public byte[] getBytes() {
            ByteBuffer buffer = ByteBuffer.allocate(getSize());
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putInt(isText ? (message.length | Integer.MIN_VALUE) : message.length);
            buffer.put(message);
            return buffer.array();
        }

        @Override
        public JSONObject getJSONObject() {
            JSONObject json = new JSONObject();
            json.put("message", isText ? Convert.toString(message) : Convert.toHexString(message));
            json.put("messageIsText", isText);
            return json;
        }

        public byte[] getMessage() {
            return message;
        }

        public boolean isText() {
            return isText;
        }
    }

    public static class EncryptedMessage implements Appendix {

        static EncryptedMessage parse(JSONObject attachmentData) throws NxtException.ValidationException {
            JSONObject encryptedMessageJSON = (JSONObject)attachmentData.get("encryptedMessage");
            if (encryptedMessageJSON == null ) {
                return null;
            }
            return new EncryptedMessage(encryptedMessageJSON);
        }

        private final EncryptedData encryptedData;
        private final boolean isText;

        EncryptedMessage(ByteBuffer buffer) throws NxtException.ValidationException {
            int length = buffer.getInt();
            this.isText = length < 0;
            if (length < 0) {
                length ^= Integer.MIN_VALUE;
            }
            this.encryptedData = EncryptedData.readEncryptedData(buffer, length, Constants.MAX_ENCRYPTED_MESSAGE_LENGTH);
        }

        EncryptedMessage(JSONObject attachmentData) throws NxtException.ValidationException {
            byte[] data = Convert.parseHexString((String)attachmentData.get("data"));
            if (data.length > Constants.MAX_ENCRYPTED_MESSAGE_LENGTH) {
                throw new NxtException.ValidationException("Max encrypted message length exceeded");
            }
            byte[] nonce = Convert.parseHexString((String)attachmentData.get("nonce"));
            if ((nonce.length != 32 && data.length > 0) || (nonce.length != 0 && data.length == 0)) {
                throw new NxtException.ValidationException("Invalid nonce length " + nonce.length);
            }
            this.encryptedData = new EncryptedData(data, nonce);
            this.isText = Boolean.TRUE.equals((Boolean)attachmentData.get("isText"));
        }

        public EncryptedMessage(EncryptedData encryptedData, boolean isText) {
            this.encryptedData = encryptedData;
            this.isText = isText;
        }

        @Override
        public int getSize() {
            return 4 + encryptedData.getSize();
        }

        @Override
        public byte[] getBytes() {
            ByteBuffer buffer = ByteBuffer.allocate(getSize());
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putInt(isText ? encryptedData.getData().length | Integer.MIN_VALUE : encryptedData.getData().length);
            buffer.put(encryptedData.getData());
            buffer.put(encryptedData.getNonce());
            return buffer.array();
        }

        @Override
        public JSONObject getJSONObject() {
            JSONObject encryptedMessageJSON = new JSONObject();
            encryptedMessageJSON.put("data", Convert.toHexString(encryptedData.getData()));
            encryptedMessageJSON.put("nonce", Convert.toHexString(encryptedData.getNonce()));
            encryptedMessageJSON.put("isText", isText);
            JSONObject json = new JSONObject();
            json.put("encryptedMessage", encryptedMessageJSON);
            return json;
        }

        public EncryptedData getEncryptedData() {
            return encryptedData;
        }

        public boolean isText() {
            return isText;
        }

    }

}