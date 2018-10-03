package main.fr.ut2j.m1ice.ootesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.Random; 

public class TestMyPoint {

	private MyPoint point;
	private MyPoint point1;
	private MyPoint point2;
	private MyPoint point3;
	private MyPoint pointNull;

	@Before
	public void setUp() throws Exception {
		point = new MyPoint();
		point1 = new MyPoint();
		point2 = new MyPoint(5.8, 3.45);
		point3 = new MyPoint(7.0, 5.0);
		pointNull = null;

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
	public void testSetNaNX() {

		point2.setX(Double.NaN);
		assertTrue(Double.isNaN(point2.getX()));
	}

	/**
	 * Test setNaN Y
	 */
	@Test
	public void testSetNaNY() {

		point2.setY(Double.NaN);
		assertTrue(Double.isNaN(point2.getY()));
	}

	/**
	 * Test le constructeur 3 avec un point == null
	 */
	@Test
	public void testMyPoint3Null() {
		MyPoint point31 = new MyPoint(pointNull);
		assertEquals(0d, point31.getX(), 0.0001);
		assertEquals(0d, point31.getY(), 0.0001);
	}

	/**
	 * Test le constructeur 3 avec un point non null
	 */
	@Test
	public void testMyPoint3NotNull() {
		MyPoint point32 = new MyPoint(point3);
		assertEquals(7, point32.getX(), 0.0001);
		assertEquals(5, point32.getY(), 0.0001);
	}

	/**
	 * Test la methode scale
	 */
	@Test
	public void testScale() {
		MyPoint pointScale = point3.scale(2);
		assertEquals(14, pointScale.getX(), 0.0001);
		assertEquals(10, pointScale.getY(), 0.0001);
	}

	/**
	 * Test la methode horizontalSymmetry
	 */
	@Test
	public void testHorizontalSymmetry() {
		MyPoint pointSymetry = point2.horizontalSymmetry(point3);
		assertEquals(8.2, pointSymetry.getX(), 0.0001);
		assertEquals(3.45, pointSymetry.getY(), 0.0001);
	}

	/**
	 * Test la methode horizontalSymmetry avec origine null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testHorizontalSymmetryNull() {
		point2.horizontalSymmetry(pointNull); 
	} 

	/**
	 * Test la methode horizontalSymmetry avec meme origine
	 */
	@Test
	public void testHorizontalSymmetrySame() {
		MyPoint pointSymetrySame = point3.horizontalSymmetry(point3);
		assertEquals(7, pointSymetrySame.getX(), 0.0001);
		assertEquals(5, pointSymetrySame.getY(), 0.0001);
	}
	
	/**
	 * Test la methode getMiddlePoint
	 */
	@Test
	public void testGetMiddlePoint() {
		MyPoint pointMiddle = point2.getMiddlePoint(point3);
		assertEquals(6.4, pointMiddle.getX(), 0.0001);
		assertEquals(4.225, pointMiddle.getY(), 0.0001);
	}
	
	/**
	 * Test la methode translate coordonnée valide
	 */
	@Test
	public void testTranslate() {
		MyPoint pointTranslate = new MyPoint(point3);
		pointTranslate.translate(3, 5);
		assertEquals(10, pointTranslate.getX(), 0.0001);
		assertEquals(10, pointTranslate.getY(), 0.0001);
	}
	
	/**
	 * Test la methode translate coordonnée non valide
	 */
	@Test
	public void testTranslateNonValide() {
		MyPoint pointTranslate = new MyPoint(point3);
		pointTranslate.translate(Double.NaN, Double.NaN);
		assertEquals(7, pointTranslate.getX(), 0.0001);
		assertEquals(5, pointTranslate.getY(), 0.0001);
		
		pointTranslate.translate(Double.NaN, 5);
		assertEquals(7, pointTranslate.getX(), 0.0001);
		assertEquals(5, pointTranslate.getY(), 0.0001);
		
		pointTranslate.translate(7, Double.NaN);		
		assertEquals(7, pointTranslate.getX(), 0.0001);
		assertEquals(5, pointTranslate.getY(), 0.0001);
	}
	
	
	/**
	 * Test la methode centralSymmetry
	 */
	@Test 
	public void testCentralSymmetry ( ) {
	    MyPoint pointCentralSymmetry = point2.centralSymmetry(point3) ;
	    assertEquals(8.2, pointCentralSymmetry.getX(), 0.0001);
		assertEquals(10.55, pointCentralSymmetry.getY(), 0.0001);
	}
	
	/**
	 * Test la methode centralSymmetry null
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testCentralSymmetrynull ( ) {
	    MyPoint pointCentralSymmetry = point2.centralSymmetry(null) ;
	}
	
/*	@Test 
	public void testCentralSymmetryNULL ( ) {
	    new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
	}*/
	
	/**
	 * Test la methode setPoint
	 */
	@Test
	public void testSetPoint() {
		
		Random mockRandomX = mock(Random.class);
		when(mockRandomX.nextInt()).thenReturn(12);
		
		Random mockRandomY = mock(Random.class);
		when(mockRandomY.nextInt()).thenReturn(6);
		
		MyPoint pointRandom = new MyPoint();
		pointRandom.setPoint(mockRandomX, mockRandomY);
		
		assertEquals(12, pointRandom.getX(), 0.0001);
		assertEquals(6, pointRandom.getY(), 0.0001);
	}
	
	/**
	 * Test la methode translate( ITranslation )
	 */
	@Test
	public void testTranslation() {
		
		ITranslation mockTranslation = mock(ITranslation.class);
		when(mockTranslation.getTx()).thenReturn(3);
		when(mockTranslation.getTy()).thenReturn(5);
		
		MyPoint pointTranslate = new MyPoint(point3);
		pointTranslate.translate(mockTranslation);
		
		assertEquals(10, pointTranslate.getX(), 0.0001);
		assertEquals(10, pointTranslate.getY(), 0.0001);
	}
	
	/**
	 * Test la methode translate( ITranslation ) non valide
	 */
	@Test
	public void testTranslationNull() {
		
		MyPoint pointTranslate = new MyPoint(point3);
		pointTranslate.translate(null);
		
		assertEquals(7, pointTranslate.getX(), 0.0001);
		assertEquals(5, pointTranslate.getY(), 0.0001);
	}

}
