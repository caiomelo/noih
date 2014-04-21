package br.ufc.edeajr.daos;

public class DaoException extends Exception {

    private static final long serialVersionUID = 5423220680715482312L;

    public DaoException(Exception ex) {
            super(ex);
    }

	public DaoException() {

	}
}
