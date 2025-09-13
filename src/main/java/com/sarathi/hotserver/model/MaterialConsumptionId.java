package com.sarathi.hotserver.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MaterialConsumptionId implements Serializable {
	private static final long serialVersionUID = 7891881216687748036L;
	private Long saleId;
    private String rId;
}
