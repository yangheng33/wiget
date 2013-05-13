package com.amar.util.math;

import java.text.DecimalFormat;

/**
 * 3d向量计算，调用取模、点乘等函数，返回的是新创建的对象，原值保持不变
 */
public class Vector3d
{
	private float x;

	private float y;

	private float z;

	public Vector3d()
	{
	}

	public Vector3d( final Vector3d d )
	{
		this.x = d.x;
		this.y = d.y;
		this.z = d.z;
	}

	public Vector3d( float x , float y , float z )
	{
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX()
	{
		return x;
	}

	public void setX( float x )
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY( float y )
	{
		this.y = y;
	}

	public float getZ()
	{
		return z;
	}

	public void setZ( float z )
	{
		this.z = z;
	}

	/**
	 * 向量取模
	 * 
	 * @return
	 */
	public float mod()
	{
		float sum = this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ();

		double sqrt = Math.sqrt( sum );

		return ( float ) sqrt;
	}

	/**
	 * 加法
	 * 
	 * @param b
	 * @return
	 */
	public Vector3d add( final Vector3d target )
	{
		Vector3d d = new Vector3d();

		d.setX( getX() + target.getX() );

		d.setY( getY() + target.getY() );

		d.setY( getY() + target.getY() );

		return d;
	}

	/**
	 * 减法
	 * 
	 * @param b
	 * @return
	 */
	public Vector3d subtraction( final Vector3d target )
	{
		Vector3d d = new Vector3d();

		d.setX( getX() - target.getX() );

		d.setY( getY() - target.getY() );

		d.setY( getY() - target.getY() );

		return d;
	}

	/**
	 * 点乘
	 * 
	 * @param b
	 * @return
	 */
	public float pointMultiply( final Vector3d target )
	{
		float result = this.getX() * target.getX() + this.getY() * target.getY() + this.getZ() * target.getZ();
		return result;
	}

	/**
	 * 夹角的余弦值
	 * 
	 * @param target
	 * @return
	 */
	public float cosAngle( final Vector3d target )
	{
		float a = this.pointMultiply( target );
		float b = this.mod();
		float c = target.mod();
		float reslut = a / ( b * c );
		return reslut;
	}

	/**
	 * 叉乘
	 * ∣a×b∣=|a|·|b|·sin〈a，b〉
	 * ∣a×b∣= ( y1*z2-z1*y2 , z1*x2-x1*z2 , x1*y2-y1*x2 )
	 * 
	 * @param b
	 * @return
	 */
	public Vector3d crossMultiply( final Vector3d target )
	{
		float _x = this.y * target.z - this.z * target.getY();
		float _y = this.z * target.x - this.x * target.getZ();
		float _z = this.x * target.y - this.y * target.getX();

		Vector3d result = new Vector3d( _x , _y , _z );

		return result;
	}

	/**
	 * 数乘
	 * 
	 * @param b
	 * @return
	 */
	public Vector3d multiply( final int target )
	{
		Vector3d d = new Vector3d( this );

		d.setX( this.getX() * target );
		d.setY( this.getY() * target );
		d.setZ( this.getZ() * target );

		return d;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append( "Vector3d [x=" ).append( x ).append( ", y=" ).append( y ).append( ", z=" ).append( z ).append( "]" );
		return builder.toString();
	}
}
