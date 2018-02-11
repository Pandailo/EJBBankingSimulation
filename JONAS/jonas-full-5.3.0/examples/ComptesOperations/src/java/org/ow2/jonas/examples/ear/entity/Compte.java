/**
 * JOnAS: Java(TM) Open Application Server
 * Copyright (C) 2007 Bull S.A.S.
 * Contact: jonas-team@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 *
 * --------------------------------------------------------------------------
 * $Id: Book.java 17350 2009-05-13 14:15:43Z fornacif $
 * --------------------------------------------------------------------------
 */

package org.ow2.jonas.examples.ear.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.math.BigDecimal;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Define a book.
 * @author Florent Benoit
 */
@Entity
@NamedQueries({@NamedQuery(name=Compte.QN.ALL_COMPTES, query="select o FROM Compte o"),
               @NamedQuery(name=Compte.QN.FIND_COMPTE, query="select o FROM Compte o WHERE o.id = :MYID")
})
public class Compte implements Serializable {

    /**
     * Defines Query names.
     */
    public static interface QN {
        /**
         * Search all books.
         */
        String ALL_COMPTES = "Compte.allComptes";

        /**
         * Search a book.
         */
        String FIND_COMPTE = "Compte.findCompte";
    }

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 0L;

    /**
     * Primary key.
     */
    private long id;
    
    /**
     * Client du compte.
     */
    private BigDecimal balance;

    /**
     * Default constructor.
     */
    public Compte() {

    }

    /**
     * Constructor. Build a new Compte with the given intitule and belonging to the
     * given client.
     * @param intitule the given title
     * @param client the given author.
     */
    public Compte(final BigDecimal balance) {
        setBalance(balance);
    }

    
    /**
     * @return the balance	 of this Compte.
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Set the intitule of the compte.
     * @param intitule - the intitule of the compte
     */
    public void setBalance(final BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return an id for this object (incremented automatically)
     */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    /**
     * Sets the id of this compte object.
     * @param id the given id of this author
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return String representation of this entity object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getName());
        sb.append("[id=");
        sb.append(getId());
        sb.append("]");
        return sb.toString();
    }
}
