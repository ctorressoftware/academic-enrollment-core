.PHONY: integration-up integration-down

integration-up:
	docker compose --env-file .env.integration -f docker-compose.integration.yml up

integration-down:
	docker compose -f docker-compose.integration.yml down