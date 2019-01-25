package org.fmat.intro.hibernate.mapping.one2many;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fmat.intro.hibernate.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book extends BaseEntity {

	private String name;

	private String isbn;

}
