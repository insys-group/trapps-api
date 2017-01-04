/**
 * 
 */
package com.insys.trapps.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author msabir
 *
 */
@Entity
@Table(name = "PERSON_SKILL")
@EqualsAndHashCode(of = {"name"}, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonSkill implements Serializable {
	private static final long serialVersionUID = -5990810947595710271L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

//    @Version
//    @Getter
//    @Setter
//    @Column(name = "VERSION")
//    private Long version;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Getter
    @Setter
    @Column(name = "NAME", nullable = false)
    private String name;
    
    @Getter
    @Setter
    @Column(name = "SCALE", nullable = false)
    private Integer scale;

	@Override
	public String toString() {
		return "PersonSkill [person=" + person + ", name=" + name + ", scale=" + scale + ", getId()=" + getId() + "]";
	}
	
//	@PrePersist
//	public void init() {
//		if(this.version==null) {
//			this.version=1L;
//		}
//	}
}