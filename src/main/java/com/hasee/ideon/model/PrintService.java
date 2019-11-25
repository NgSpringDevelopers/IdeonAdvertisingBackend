package com.hasee.ideon.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "IDN_PRINT_SERVICE")
public class PrintService
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Long id;

	@Column(name = "NAME")
	String name;

	@ManyToOne(cascade = CascadeType.DETACH)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "CATEGORY", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CATEGORY2PRINT_SERVICE"))
	Category category;

	@Column(name = "UNIT")
	String unit;

	@Column(name = "IMAGE")
	@Lob
	String image;

	@Column(name = "PRICE")
	double price;

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory( Category category )
	{
		this.category = category;
	}

	public String getUnit()
	{
		return unit;
	}

	public void setUnit( String unit )
	{
		this.unit = unit;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage( String image )
	{
		this.image = image;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice( double price )
	{
		this.price = price;
	}
}
