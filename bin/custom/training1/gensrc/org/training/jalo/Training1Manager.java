/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 12, 2023, 5:39:06 PM                    ---
 * ----------------------------------------------------------------
 */
package org.training.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.extension.ExtensionManager;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.CollectionType;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.util.OneToManyHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.training.constants.Training1Constants;
import org.training.jalo.Manufacturer;
import org.training.jalo.ProductVariant;
import org.training.jalo.Promotion;

/**
 * Generated class for type <code>Training1Manager</code>.
 */
@SuppressWarnings({"unused","cast"})
@SLDSafe
public class Training1Manager extends Extension
{
	/** Relation ordering override parameter constants for Promotion2Product from ((training1))*/
	protected static String PROMOTION2PRODUCT_SRC_ORDERED = "relation.Promotion2Product.source.ordered";
	protected static String PROMOTION2PRODUCT_TGT_ORDERED = "relation.Promotion2Product.target.ordered";
	/** Relation disable markmodifed parameter constants for Promotion2Product from ((training1))*/
	protected static String PROMOTION2PRODUCT_MARKMODIFIED = "relation.Promotion2Product.markmodified";
	/**
	* {@link OneToManyHandler} for handling 1:n VARIANTITEMS's relation attributes from 'many' side.
	**/
	protected static final OneToManyHandler<ProductVariant> PRODUCT2VARIANTVARIANTITEMSHANDLER = new OneToManyHandler<ProductVariant>(
	Training1Constants.TC.PRODUCTVARIANT,
	false,
	"product",
	null,
	false,
	true,
	CollectionType.COLLECTION
	);
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	public Manufacturer createManufacturer(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("Manufacturer");
			return (Manufacturer)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Manufacturer : "+e.getMessage(), 0 );
		}
	}
	
	public Manufacturer createManufacturer(final Map attributeValues)
	{
		return createManufacturer( getSession().getSessionContext(), attributeValues );
	}
	
	public ProductVariant createProductVariant(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("ProductVariant");
			return (ProductVariant)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ProductVariant : "+e.getMessage(), 0 );
		}
	}
	
	public ProductVariant createProductVariant(final Map attributeValues)
	{
		return createProductVariant( getSession().getSessionContext(), attributeValues );
	}
	
	public Promotion createPromotion(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType("Promotion");
			return (Promotion)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Promotion : "+e.getMessage(), 0 );
		}
	}
	
	public Promotion createPromotion(final Map attributeValues)
	{
		return createPromotion( getSession().getSessionContext(), attributeValues );
	}
	
	public static final Training1Manager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (Training1Manager) em.getExtension(Training1Constants.EXTENSIONNAME);
	}
	
	@Override
	public String getName()
	{
		return Training1Constants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.promotions</code> attribute.
	 * @return the promotions
	 */
	public Collection<Promotion> getPromotions(final SessionContext ctx, final Product item)
	{
		final List<Promotion> items = item.getLinkedItems( 
			ctx,
			false,
			Training1Constants.Relations.PROMOTION2PRODUCT,
			"Promotion",
			null,
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.promotions</code> attribute.
	 * @return the promotions
	 */
	public Collection<Promotion> getPromotions(final Product item)
	{
		return getPromotions( getSession().getSessionContext(), item );
	}
	
	public long getPromotionsCount(final SessionContext ctx, final Product item)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			Training1Constants.Relations.PROMOTION2PRODUCT,
			"Promotion",
			null
		);
	}
	
	public long getPromotionsCount(final Product item)
	{
		return getPromotionsCount( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.promotions</code> attribute. 
	 * @param value the promotions
	 */
	public void setPromotions(final SessionContext ctx, final Product item, final Collection<Promotion> value)
	{
		item.setLinkedItems( 
			ctx,
			false,
			Training1Constants.Relations.PROMOTION2PRODUCT,
			null,
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(PROMOTION2PRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.promotions</code> attribute. 
	 * @param value the promotions
	 */
	public void setPromotions(final Product item, final Collection<Promotion> value)
	{
		setPromotions( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to promotions. 
	 * @param value the item to add to promotions
	 */
	public void addToPromotions(final SessionContext ctx, final Product item, final Promotion value)
	{
		item.addLinkedItems( 
			ctx,
			false,
			Training1Constants.Relations.PROMOTION2PRODUCT,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PROMOTION2PRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to promotions. 
	 * @param value the item to add to promotions
	 */
	public void addToPromotions(final Product item, final Promotion value)
	{
		addToPromotions( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from promotions. 
	 * @param value the item to remove from promotions
	 */
	public void removeFromPromotions(final SessionContext ctx, final Product item, final Promotion value)
	{
		item.removeLinkedItems( 
			ctx,
			false,
			Training1Constants.Relations.PROMOTION2PRODUCT,
			null,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(PROMOTION2PRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from promotions. 
	 * @param value the item to remove from promotions
	 */
	public void removeFromPromotions(final Product item, final Promotion value)
	{
		removeFromPromotions( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.variantItems</code> attribute.
	 * @return the variantItems
	 */
	public Collection<ProductVariant> getVariantItems(final SessionContext ctx, final Product item)
	{
		return PRODUCT2VARIANTVARIANTITEMSHANDLER.getValues( ctx, item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.variantItems</code> attribute.
	 * @return the variantItems
	 */
	public Collection<ProductVariant> getVariantItems(final Product item)
	{
		return getVariantItems( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.variantItems</code> attribute. 
	 * @param value the variantItems
	 */
	public void setVariantItems(final SessionContext ctx, final Product item, final Collection<ProductVariant> value)
	{
		PRODUCT2VARIANTVARIANTITEMSHANDLER.setValues( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.variantItems</code> attribute. 
	 * @param value the variantItems
	 */
	public void setVariantItems(final Product item, final Collection<ProductVariant> value)
	{
		setVariantItems( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to variantItems. 
	 * @param value the item to add to variantItems
	 */
	public void addToVariantItems(final SessionContext ctx, final Product item, final ProductVariant value)
	{
		PRODUCT2VARIANTVARIANTITEMSHANDLER.addValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to variantItems. 
	 * @param value the item to add to variantItems
	 */
	public void addToVariantItems(final Product item, final ProductVariant value)
	{
		addToVariantItems( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from variantItems. 
	 * @param value the item to remove from variantItems
	 */
	public void removeFromVariantItems(final SessionContext ctx, final Product item, final ProductVariant value)
	{
		PRODUCT2VARIANTVARIANTITEMSHANDLER.removeValue( ctx, item, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from variantItems. 
	 * @param value the item to remove from variantItems
	 */
	public void removeFromVariantItems(final Product item, final ProductVariant value)
	{
		removeFromVariantItems( getSession().getSessionContext(), item, value );
	}
	
}
