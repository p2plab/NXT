### NXT ALTCOIN 만들기

Make new accounts for genesis + recipients using standard NXT.

Update new values in Genesis.java for CREATOR_ID, CREATOR_PUBLIC_KEY, GENESIS_RECIPIENTS, GENESIS_AMOUNTS. (Hint: Crypto.getPublicKey)

Sign the transactions manually (change the signature parameter to null) in "addGenesisBlock".

Output signatures and update to GENESIS_SIGNATURES in Genesis.java

Same thing, but for the block this time. Sign manually, output signature and replace to GENESIS_BLOCK_SIGNATURE in Genesis.java

Finally, take the id of the signed genesis block, and update to GENESIS_BLOCK_ID.