package com.FTR.Terminals.exception;

public enum ExceptionConstants {
    
    TERMINAL_ITEMTYPE_NOTFOUND("terminal.itemtype.notFound"),
    TERMINAL_NOTFOUND("terminal.notFound"),
    SERVER_ERROR("general.exception"),
    TERMINAL_CAPACITY_FAILED("terminal.capacity.failed"),
    TERMINAL_ALREADY_EXISTS("terminal.exists"),
    TERMINAL_EMPTY("terminal.empty");

    private final String type;

    ExceptionConstants(String type){
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
