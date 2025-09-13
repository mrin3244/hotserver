package com.sarathi.hotserver.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class ClosingStockId implements Serializable {
	private static final long serialVersionUID = -3162981191440279915L;
	private LocalDate date;
    private String rId;
}