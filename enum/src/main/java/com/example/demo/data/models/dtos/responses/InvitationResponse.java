package com.example.demo.data.models.dtos.responses;

import com.example.demo.data.models.entities.Invitation;
import com.example.demo.data.models.enums.InvitationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class InvitationResponse {
    private boolean success;;
    private String message;
    private Invitation data;
}
