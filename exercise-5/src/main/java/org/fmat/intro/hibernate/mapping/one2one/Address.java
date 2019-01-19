package org.fmat.intro.hibernate.mapping.one2one;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Address {

	@Id
	private Integer id;

	private String address;

	private String city;

	@Column(name = "zip_code")
	private int zipCode;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Student student;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Address{");
		sb.append("id=").append(id);
		sb.append(", address='").append(address).append('\'');
		sb.append(", city='").append(city).append('\'');
		sb.append(", zipCode=").append(zipCode);
		sb.append('}');
		return sb.toString();
	}
}
