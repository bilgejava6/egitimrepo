package com.volkangenel.odev.repository;

import java.util.List;

public abstract class AbstractDepartman <Departman> {

    public abstract void save(Departman t);

    public abstract List <Departman> findAll ();
}
