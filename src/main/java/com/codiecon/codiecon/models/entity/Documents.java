package com.codiecon.codiecon.models.entity;

import com.codiecon.codiecon.models.enums.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = Documents.TABLE_NAME)
public class Documents {

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(name = "documents_id", nullable = false)
  private String id;
  public static final String TABLE_NAME = "documents";
  private String email;

  private String documentName;

  @Enumerated(value = EnumType.STRING)
  private DocumentType documentType;

  public Documents(String email, String documentName, DocumentType documentType) {
    this.email = email;
    this.documentName = documentName;
    this.documentType = documentType;
  }
}
