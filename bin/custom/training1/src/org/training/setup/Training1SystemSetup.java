/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.training.setup;

import static org.training.constants.Training1Constants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import org.training.constants.Training1Constants;
import org.training.service.Training1Service;


@SystemSetup(extension = Training1Constants.EXTENSIONNAME)
public class Training1SystemSetup
{
	private final Training1Service training1Service;

	public Training1SystemSetup(final Training1Service training1Service)
	{
		this.training1Service = training1Service;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		training1Service.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return Training1SystemSetup.class.getResourceAsStream("/training1/sap-hybris-platform.png");
	}
}
