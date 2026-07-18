# ChatClearOnJoin

Clears the chat 1 second after a player joins.

## Setup
1. Build jar via GitHub Actions or `mvn package`
2. Put `ChatClearOnJoin-1.0.0.jar` into `plugins/`
3. Start server once -> `plugins/ChatClearOnJoin/config.yml` is created
4. Config:
   delay-seconds: 1
   clear-lines: 100
   clear-for-all: true (false = only clear for joiner)
5. Restart.

Works on Paper / Purpur 1.21+ Java 21
