package com.system.growth_system.util.enums;

public enum InventoryResponse {
    SUCCESS_SAVE_INVENTORY("¡Inventario Guardado!"),
    SERIAL_NUMBER_DUPLICATE("Numero de serial duplicado"),

    SUCCESSFULLY_REMOVED("¡Inventario Eliminado!"),

    NOT_FOUND("Inventario no encontrado")
    ;

    private final String value;

    InventoryResponse(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
