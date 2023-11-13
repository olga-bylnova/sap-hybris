/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Nov 14, 2023, 1:18:10 AM                    ---
 * ----------------------------------------------------------------
 */
package org.training.constants;

/**
 * @deprecated since ages - use constants in Model classes instead
 */
@Deprecated(since = "ages", forRemoval = false)
@SuppressWarnings({"unused","cast"})
public class GeneratedTraining1Constants
{
	public static final String EXTENSIONNAME = "training1";
	public static class TC
	{
		public static final String DISCOUNTTYPE = "DiscountType".intern();
		public static final String MANUFACTURER = "Manufacturer".intern();
		public static final String PRODUCTCATEGORY = "ProductCategory".intern();
		public static final String PRODUCTVARIANT = "ProductVariant".intern();
		public static final String PROMOTION = "Promotion".intern();
		public static final String TYPEWITHATTRIBUTES = "TypeWithAttributes".intern();
	}
	public static class Attributes
	{
		public static class Product
		{
			public static final String PROMOTIONS = "promotions".intern();
			public static final String VARIANTITEMS = "variantItems".intern();
		}
	}
	public static class Enumerations
	{
		public static class DiscountType
		{
			public static final String PERCENTAGE = "Percentage".intern();
			public static final String FIXEDAMOUNT = "FixedAmount".intern();
			public static final String BUNDLEDISCOUNT = "BundleDiscount".intern();
		}
		public static class ProductCategory
		{
			public static final String ELECTRONICS = "Electronics".intern();
			public static final String CLOTHING = "Clothing".intern();
			public static final String SPORTS = "Sports".intern();
			public static final String HOME = "Home".intern();
		}
	}
	public static class Relations
	{
		public static final String PRODUCT2VARIANT = "Product2Variant".intern();
		public static final String PROMOTION2PRODUCT = "Promotion2Product".intern();
	}
	
	protected GeneratedTraining1Constants()
	{
		// private constructor
	}
	
	
}
