/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2021, by David Gilbert and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ------------------
 * TextTitleTest.java
 * ------------------
 * (C) Copyright 2004-2021, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   Tracy Hiltbrand;
 *
 */

package org.jfree.chart.title;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.jfree.chart.TestUtils;
import org.jfree.chart.ui.HorizontalAlignment;

import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link TextTitle} class.
 */
public class TextTitleTest {
    @Test
    public void testEqualsHashCode() {
        EqualsVerifier.forClass(TextTitle.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .suppress(Warning.NONFINAL_FIELDS)
                .withRedefinedSuperclass()
                .withPrefabValues(Rectangle2D.class,
                                  TestUtils.createR2D(true),
                                  TestUtils.createR2D(false))
                .withPrefabValues(Font.class,
                                  TestUtils.createFont(true),
                                  TestUtils.createFont(false))
                .verify();
    }
    /**
     * Check that the equals() method distinguishes all fields.
     */
    @Test
    public void testEquals() {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = new TextTitle();
        assertEquals(t1, t2);

        t1.setText("Test 1");
        assertFalse(t1.equals(t2));
        t2.setText("Test 1");
        assertTrue(t1.equals(t2));

        Font f = new Font("SansSerif", Font.PLAIN, 15);
        t1.setFont(f);
        assertFalse(t1.equals(t2));
        t2.setFont(f);
        assertTrue(t1.equals(t2));

        t1.setTextAlignment(HorizontalAlignment.RIGHT);
        assertFalse(t1.equals(t2));
        t2.setTextAlignment(HorizontalAlignment.RIGHT);
        assertTrue(t1.equals(t2));

        // paint
        t1.setPaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        assertFalse(t1.equals(t2));
        t2.setPaint(new GradientPaint(1.0f, 2.0f, Color.RED,
                3.0f, 4.0f, Color.BLUE));
        assertTrue(t1.equals(t2));

        // backgroundPaint
        t1.setBackgroundPaint(new GradientPaint(4.0f, 3.0f, Color.RED,
                2.0f, 1.0f, Color.BLUE));
        assertFalse(t1.equals(t2));
        t2.setBackgroundPaint(new GradientPaint(4.0f, 3.0f, Color.RED,
                2.0f, 1.0f, Color.BLUE));
        assertTrue(t1.equals(t2));

        // maximumLinesToDisplay
        t1.setMaximumLinesToDisplay(3);
        assertFalse(t1.equals(t2));
        t2.setMaximumLinesToDisplay(3);
        assertTrue(t1.equals(t2));

        // toolTipText
        t1.setToolTipText("TTT");
        assertFalse(t1.equals(t2));
        t2.setToolTipText("TTT");
        assertTrue(t1.equals(t2));

        // urlText
        t1.setURLText(("URL"));
        assertFalse(t1.equals(t2));
        t2.setURLText(("URL"));
        assertTrue(t1.equals(t2));

        // expandToFitSpace
        t1.setExpandToFitSpace(!t1.getExpandToFitSpace());
        assertFalse(t1.equals(t2));
        t2.setExpandToFitSpace(!t2.getExpandToFitSpace());
        assertTrue(t1.equals(t2));

    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashcode() {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = new TextTitle();
        assertTrue(t1.equals(t2));
        int h1 = t1.hashCode();
        int h2 = t2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        TextTitle t1 = new TextTitle();
        TextTitle t2 = (TextTitle) t1.clone();
        assertTrue(t1 != t2);
        assertTrue(t1.getClass() == t2.getClass());
        assertTrue(t1.equals(t2));
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        TextTitle t1 = new TextTitle("Test");
        TextTitle t2 = TestUtils.serialised(t1);
        assertEquals(t1, t2);
    }

}
