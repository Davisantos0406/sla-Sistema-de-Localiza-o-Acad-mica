package com.uniceplac.sla.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.uniceplac.sla.dao.DisciplinaDao;
import com.uniceplac.sla.dao.SalaDao;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

class ProfessorAulaBeanTest {

    @Test
    void initShouldLoadFormOptionsWithoutRedirecting() throws Exception {
        ProfessorAulaBean bean = new ProfessorAulaBean();
        DisciplinaDao disciplinaDao = mock(DisciplinaDao.class);
        SalaDao salaDao = mock(SalaDao.class);
        setField(bean, "disciplinaDao", disciplinaDao);
        setField(bean, "salaDao", salaDao);

        FacesContext facesContext = mock(FacesContext.class);
        ExternalContext externalContext = mock(ExternalContext.class);
        Map<String, Object> sessionMap = new HashMap<>();

        when(disciplinaDao.listarTodas()).thenReturn(List.of());
        when(salaDao.listarTodas()).thenReturn(List.of());
        when(facesContext.getExternalContext()).thenReturn(externalContext);
        when(externalContext.getSessionMap()).thenReturn(sessionMap);

        try (MockedStatic<FacesContext> mockedFacesContext = mockStatic(FacesContext.class)) {
            mockedFacesContext.when(FacesContext::getCurrentInstance).thenReturn(facesContext);

            bean.init();

            verify(disciplinaDao).listarTodas();
            verify(salaDao).listarTodas();
            verify(externalContext, never()).redirect(anyString());
        }
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        var field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
