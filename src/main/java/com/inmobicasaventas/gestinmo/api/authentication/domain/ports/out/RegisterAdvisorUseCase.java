package com.inmobicasaventas.gestinmo.api.authentication.domain.ports.out;

import com.inmobicasaventas.gestinmo.api.authentication.domain.models.Advisor;

public interface RegisterAdvisorUseCase {
    void registerAdvisor(Advisor advisor);
}
