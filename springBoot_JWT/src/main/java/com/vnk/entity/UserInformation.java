package com.vnk.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class UserInformation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Nonnull
@Column(length = 40)
private String email;
@Nonnull
private String password;
@Nonnull
private Long mobileNo;
@Nonnull
@Column(length = 40)
private String username;
}
