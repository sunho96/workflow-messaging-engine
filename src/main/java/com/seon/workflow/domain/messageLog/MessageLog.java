package com.seon.workflow.domain.messageLog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_log")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "action_id", nullable = false)
    private Long actionId;

    @Column(nullable = false)
    private String status;

    @Lob
    @Column(name = "request_payload", nullable = false, columnDefinition = "jsonb")
    private String requestPayLoad;

    @Lob
    @Column(name = "response_payload", columnDefinition = "jsonb")
    private String responsePayLoad;

    @Column(name = "sent_at", nullable = false)
    private LocalDateTime sentAt;

    @PrePersist
    protected void onCreate() {
        this.sentAt = LocalDateTime.now();
    }

}
