package com.inmobicasaventas.gestinmo.api.documents.domain.models;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@Data
public class Document {
    private String name;
    private File file;
}
