# Webhook + Async API Project

## 개요

이 프로젝트는 웹훅 이벤트를 처리하고, 비동기로 이메일 알림을 전송하는 Spring Boot 애플리케이션입니다. 클린 아키텍처를 기반으로 설계되었으며, 애플리케이션의 비즈니스 로직과 외부 시스템 간의 상호작용을 명확히 구분합니다.

## 주요 구성 요소

- **도메인 모델**: 애플리케이션의 핵심 비즈니스 로직을 정의합니다. (`Notification`, `WebhookPayload`)
- **유스케이스**: 비즈니스 로직을 구현하며, 도메인 모델과 상호작용합니다. (`ProcessWebhookUseCase`)
- **어댑터**: 외부 시스템과의 상호작용을 처리합니다. (`NotificationService`, `WebhookController`, `InMemoryWebhookPayloadRepository`)
- **설정**: 비동기 작업 및 기타 설정을 구성합니다. (`AsyncConfig`)

## 엔드포인트
`POST /webhook/subscribe`       
1. 웹훅 페이로드를 수신하고 비즈니스 로직을 처리합니다.
2. 처리 완료 후 이메일 알림을 비동기로 전송합니다.

요청 본문 예시:
```  
json
코드 복사
{
"payload": "example payload data"
}
```

응답:

* HTTP 200 OK: 요청이 성공적으로 처리되었습니다.