package com.sarathi.hotserver.model;

import java.io.Serializable;

public class ProductMaterialId implements Serializable {
    private String pId;
    private String rId;

    public ProductMaterialId() {}
    public ProductMaterialId(String pId, String rId) { this.pId = pId; this.rId = rId; }
    // equals & hashCode (can be generated)
    @Override public boolean equals(Object o){
        if(this==o) return true;
        if(o==null||getClass()!=o.getClass()) return false;
        ProductMaterialId that = (ProductMaterialId)o;
        return java.util.Objects.equals(pId, that.pId) && java.util.Objects.equals(rId, that.rId);
    }
    @Override public int hashCode(){ return java.util.Objects.hash(pId, rId); }
}