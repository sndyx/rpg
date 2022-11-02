package net.aradiata.item;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J\u0011\u0010\b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096\u0001J\u0017\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096\u0001J\t\u0010\u0010\u001a\u00020\tH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u0012\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096\u0001J\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0003J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0015\u001a\u00020\fH\u0096\u0001J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0003J\u0011\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001aH\u0096\u0001J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001J\u0017\u0010\u001c\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096\u0001J\u0011\u0010\u001d\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001J\u0017\u0010\u001e\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0096\u0001J\u0019\u0010\u001f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0003J\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006#"}, d2 = {"Lnet/aradiata/item/ItemRegistry;", "", "Lnet/aradiata/item/Item;", "()V", "size", "", "getSize", "()I", "add", "", "index", "element", "", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "subList", "fromIndex", "toIndex", "plugin"})
public final class ItemRegistry implements java.util.List<net.aradiata.item.Item>, kotlin.jvm.internal.markers.KMutableList {
    @org.jetbrains.annotations.NotNull
    public static final net.aradiata.item.ItemRegistry INSTANCE = null;
    
    private ItemRegistry() {
        super();
    }
    
    @java.lang.Override
    public void add(int index, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
    }
    
    @java.lang.Override
    public boolean add(@org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return false;
    }
    
    @java.lang.Override
    public boolean addAll(int index, @org.jetbrains.annotations.NotNull
    java.util.Collection<? extends net.aradiata.item.Item> elements) {
        return false;
    }
    
    @java.lang.Override
    public boolean addAll(@org.jetbrains.annotations.NotNull
    java.util.Collection<? extends net.aradiata.item.Item> elements) {
        return false;
    }
    
    @java.lang.Override
    public void clear() {
    }
    
    @java.lang.Override
    public final boolean contains(java.lang.Object element) {
        return false;
    }
    
    @java.lang.Override
    public boolean contains(@org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return false;
    }
    
    @java.lang.Override
    public boolean containsAll(@org.jetbrains.annotations.NotNull
    java.util.Collection<? extends java.lang.Object> elements) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Item get(int index) {
        return null;
    }
    
    @java.lang.Override
    public int getSize() {
        return 0;
    }
    
    @java.lang.Override
    public final int indexOf(java.lang.Object element) {
        return 0;
    }
    
    @java.lang.Override
    public int indexOf(@org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return 0;
    }
    
    @java.lang.Override
    public boolean isEmpty() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.Iterator<net.aradiata.item.Item> iterator() {
        return null;
    }
    
    @java.lang.Override
    public final int lastIndexOf(java.lang.Object element) {
        return 0;
    }
    
    @java.lang.Override
    public int lastIndexOf(@org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.ListIterator<net.aradiata.item.Item> listIterator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.ListIterator<net.aradiata.item.Item> listIterator(int index) {
        return null;
    }
    
    @java.lang.Override
    public final net.aradiata.item.Item remove(int index) {
        return null;
    }
    
    @java.lang.Override
    public final boolean remove(java.lang.Object element) {
        return false;
    }
    
    @java.lang.Override
    public boolean remove(@org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return false;
    }
    
    @java.lang.Override
    public boolean removeAll(@org.jetbrains.annotations.NotNull
    java.util.Collection<? extends java.lang.Object> elements) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Item removeAt(int index) {
        return null;
    }
    
    @java.lang.Override
    public boolean retainAll(@org.jetbrains.annotations.NotNull
    java.util.Collection<? extends java.lang.Object> elements) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public net.aradiata.item.Item set(int index, @org.jetbrains.annotations.NotNull
    net.aradiata.item.Item element) {
        return null;
    }
    
    @java.lang.Override
    public final int size() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.util.List<net.aradiata.item.Item> subList(int fromIndex, int toIndex) {
        return null;
    }
}