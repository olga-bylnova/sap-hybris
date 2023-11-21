/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.setup;

import static org.training.constants.ExtensionAConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.ExtensionAConstants;
import org.training.service.ExtensionAService;


@SystemSetup(extension = ExtensionAConstants.EXTENSIONNAME)
public class ExtensionASystemSetup
{
	private final ExtensionAService extensionAService;

	public ExtensionASystemSetup(final ExtensionAService extensionAService)
	{
		this.extensionAService = extensionAService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		extensionAService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return ExtensionASystemSetup.class.getResourceAsStream("/extensionA/sap-hybris-platform.png");
	}
}
