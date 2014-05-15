package com.gravypod.starmadewrapper.plugins.material;

import com.gravypod.starmadewrapper.Material;

public class MaterialData implements Cloneable {

    private final int type;
    private byte data = 0;

    public MaterialData(final int type) {
        this(type, (byte) 0);
    }

    public MaterialData(final Material type) {
        this(type, (byte) 0);
    }

    public MaterialData(final int type, final byte data) {
        this.type = type;
        this.data = data;
    }

    public MaterialData(final Material type, final byte data) {
        this(type.getId(), data);
    }

    /**
     * Gets the raw data in this material
     *
     * @return Raw data
     */
    public byte getData() {
        return data;
    }

    /**
     * Sets the raw data in this material
     *
     * @param data New raw data
     */
    public void setData(byte data) {
        this.data = data;
    }

    /**
     * Gets the Material that this MaterialData represents
     *
     * @return Material represented by this Material Data
     */
    public Material getMaterial() {
        return Material.getMaterial(type);
    }

    /**
     * Gets the Material ID that this MaterialData represents
     *
     * @return Material ID represented by this Material Data
     */
    public int getTypeId() {
        return type;
    }

    @Override
    public int hashCode() {
        return ((getTypeId() << 8) ^ getData());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MaterialData) {
            MaterialData materialData = (MaterialData) obj;

            return (materialData.getTypeId() == getTypeId() && materialData.getData() == getData());
        } else {
            return false;
        }
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }

    @Override
    public String toString() {
        return getMaterial() + "(" + getData() + ")";
    }
}
