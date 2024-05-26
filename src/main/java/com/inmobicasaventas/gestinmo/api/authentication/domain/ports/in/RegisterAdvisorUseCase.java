package com.inmobicasaventas.gestinmo.api.authentication.domain.ports.in;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;

public interface RegisterAdvisorUseCase {
    boolean registerAdvisor(Advisor advisor, String password);
}
