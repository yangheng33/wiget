package com.amar.model;
public class Project
{
private int id;

private String name;

private String remark;


public void setId( int id )
{
this.id=id;
}

public int getId()
{
return this.id;
}

public void setName( String name )
{
this.name=name;
}

public String getName()
{
return this.name;
}

public void setRemark( String remark )
{
this.remark=remark;
}

public String getRemark()
{
return this.remark;
}

}