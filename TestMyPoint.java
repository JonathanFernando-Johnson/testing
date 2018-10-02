package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyPoint {
	
	private MyPoint point;
	private MyPoint point1;
	private MyPoint point2;	
	private MyPoint point3;	

	@Before
	public void setUp() throws Exception {
		point = new MyPoint();
		point1 = new MyPoint();
		point2 = new MyPoint(5.8, 3.45);
		point3 = new MyPoint(7.0, 5.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	/**
	 * Test get et set X
	 */
	@Test
	public void testGetSetX() {

		assertEquals(0d, point.getX(), 0.0001);
		point.setX(14.3);
		assertEquals(14.3, point.getX(), 0.0001);
	}
	
	/**
	 * Test get et set Y
	 */
	@Test
	public void testGetSetY() {

		assertEquals(0d, point.getY(), 0.0001);
		point.setY(14.3);
		assertEquals(14.3, point.getY(), 0.0001);
	}
	
	
	/**
	 * Test le constructeur 1
	 */
	@Test
	public void testMyPoint1() {	

		assertEquals(0d, point1.getX(), 0.0001);
		assertEquals(0d, point1.getY(), 0.0001);
	}
	
	/**
	 * Test le constructeur 2
	 */
	@Test
	public void testMyPoint2() {

		assertEquals(5.8, point2.getX(), 0.0001);
		assertEquals(3.45, point2.getY(), 0.0001);
	}
	
	/**
	 * Test setNaN X
	 */
	@Test
	public void testsetNaNX() {

		point2.setX(Double.NaN);
		assertTrue(Double.isNaN(point2.getX()));
	}
	
	/**
	 * Test setNaN Y
	 */
	@Test
	public void testsetNaNY() {
		point2.setY(Double.NaN);
		assertTrue(Double.isNaN(point2.getY()));
	}
	
	/**
	 * Test le constructeur 3 avec un point == null
	 */
	@Test
	public void testMyPoint3Null() {
		MyPoint pointNull = null;
		point = new MyPoint(pointNull);
		assertEquals(0d, point.getX(), 0.0001);
		assertEquals(0d, point.getY(), 0.0001);
	}
	
	/**
	 * Test le constructeur 3 avec un point non null
	 */
	@Test
	public void testMyPoint3NotNull() {
		point = new MyPoint(point3);
		assertEquals(7, point.getX(), 0.0001);
		assertEquals(5, point.getY(), 0.0001);
	}

}
