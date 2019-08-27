package org.diverproject.scarlet.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.diverproject.scarlet.util.ScarletUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Scarlet Utils")
public class TestScarletUtils
{
	@Test
	@DisplayName("NVL")
	public void testNvl()
	{
		assertEquals(ScarletUtils.nvl(Integer.class, 1, 1), 1);
		assertEquals(ScarletUtils.nvl(Integer.class, 1, null), 1);
		assertEquals(ScarletUtils.nvl(Integer.class, null, 1), 1);
		assertNull(ScarletUtils.nvl(Integer.class, null, null));
	}
}
