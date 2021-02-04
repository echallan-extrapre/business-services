package org.egov.web.notification.producer.contract;

import java.util.List;

import org.egov.web.notification.model.Attachment;
import org.egov.web.notification.model.Email;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class EmailRequest {
	private String email;
	private String subject;
	private String body;
	@JsonProperty("isHTML")
	private boolean isHTML;
	/********* Attachment Related Enhancement ************/
	private List<Attachment> attachments;

	public Email toDomain() {

		return Email.builder().toAddress(email).subject(subject).body(body).html(isHTML).attachments(attachments)
				.build();
   	 }
}