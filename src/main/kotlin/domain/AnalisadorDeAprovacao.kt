package domain

import domain.criterios.Basico
import domain.criterios.CriterioDeAprovacao
import domain.BoletimFechado
import domain.Boletim

@Suppress("unused")

class AnalisadorDeAprovacao {
    // variáveis de uso
    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(criterio_sub: CriterioDeAprovacao) {
        criterio = criterio_sub
    }
    
    fun fechaBoletim(boletim: Boletim): BoletimFechado {
        
        val boletim_fechado = BoletimFechado(
            mediaEPs = boletim.mediaEPs,
            mediaMiniEPs = boletim.mediaMiniEPs,
            mediaFinal = criterio.mediaFinal(boletim),
            foiAprovado = criterio.estaAprovado(boletim)
        )

        //println("Boletim criado")

        return boletim_fechado

    }

}