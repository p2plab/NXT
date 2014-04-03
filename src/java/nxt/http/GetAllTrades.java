package nxt.http;

import nxt.Trade;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

import static nxt.http.JSONResponses.INCORRECT_TIMESTAMP;
import static nxt.http.JSONResponses.MISSING_TIMESTAMP;

public final class GetAllTrades extends APIServlet.APIRequestHandler {

    static final GetAllTrades instance = new GetAllTrades();

    private GetAllTrades() {
        super("timestamp");
    }
    
    @Override
    JSONStreamAware processRequest(HttpServletRequest req) {

        String timestampValue = req.getParameter("timestamp");
        if (timestampValue == null) {
            return MISSING_TIMESTAMP;
        }

        int timestamp;
        try {
            timestamp = Integer.parseInt(timestampValue);
            if (timestamp < 0) {
                return INCORRECT_TIMESTAMP;
            }
        } catch (NumberFormatException e) {
            return INCORRECT_TIMESTAMP;
        }

        JSONObject response = new JSONObject();
        
        JSONArray tradesData = new JSONArray();

        try {
            Collection<List<Trade>> trades = Trade.getAllTrades();

            for (List<Trade> assetTrades : trades) {
                for (Trade trade : assetTrades) {
                    if (trade.getTimestamp() >= timestamp) {
                        tradesData.add(JSONData.trade(trade));
                    }
                }
            }
        } catch (RuntimeException e) {
            response.put("error", e.toString());
        }

        response.put("trades", tradesData);
        return response;
    }

}
