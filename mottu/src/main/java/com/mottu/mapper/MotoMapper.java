package com.mottu.mapper;

import com.mottu.DTO.MotoDTO;
import com.mottu.model.Galpao;
import com.mottu.model.Moto;

public class MotoMapper {

    public static MotoDTO toDTO(Moto moto) {
        MotoDTO dto = new MotoDTO();
        dto.setId(moto.getId());
        dto.setModelo(moto.getModelo());
        dto.setPlaca(moto.getPlaca());
        dto.setDisponivel(moto.getDisponibilidade());
        dto.setGalpaoId(moto.getGalpao().getId());
        return dto;
    }

    public static Moto toEntity(MotoDTO dto, Galpao galpao) {
        Moto moto = new Moto();
        moto.setId(dto.getId());
        moto.setModelo(dto.getModelo());
        moto.setPlaca(dto.getPlaca());
        moto.setDisponibilidade(dto.getDisponivel());
        moto.setGalpao(galpao);
        return moto;
    }
}
