package com.twu.biblioteca;

public abstract class LibraryItems {
    public abstract boolean isCheckedOut();

    public abstract void checkout();

    public abstract boolean hasName(String movieInput);
}
