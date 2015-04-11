/*
 * Copyright 2015 Tagir Valeev
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package javax.util.streamex;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleStreamExTest {
	@Test
	public void testCreate() {
		assertArrayEquals(new double[] {}, DoubleStreamEx.empty().toArray(), 0.0);
		assertArrayEquals(new double[] {1}, DoubleStreamEx.of(1).toArray(), 0.0);
		assertArrayEquals(new double[] {1, 2, 3}, DoubleStreamEx.of(1, 2, 3).toArray(), 0.0);
		assertArrayEquals(new double[] {1, 2, 3}, DoubleStreamEx.of(Arrays.asList(1.0, 2.0, 3.0)).toArray(), 0.0);
	}
	
	@Test
	public void testPrepend() {
		assertArrayEquals(new double[] { -1, 0, 1, 2, 3 }, DoubleStreamEx.of(1, 2, 3)
				.prepend(-1, 0).toArray(), 0.0);
	}
	
	@Test
	public void testAppend() {
		assertArrayEquals(new double[] { 1, 2, 3, 4, 5 }, DoubleStreamEx.of(1, 2, 3)
				.append(4, 5).toArray(), 0.0);
	}

	@Test
	public void testFind() {
		assertEquals(6.0, LongStreamEx.range(1, 10).asDoubleStream().findFirst(i -> i > 5).getAsDouble(), 0.0);
		assertFalse(LongStreamEx.range(1, 10).asDoubleStream().findAny(i -> i > 10).isPresent());
	}

}