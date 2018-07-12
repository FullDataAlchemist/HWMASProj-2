/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massim.javaagents.percept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Poney
 */
public class Shop
{
	// shop lat="48.85888" lon="2.40388" name="shop2" restock="2"
	private double					shopLat;
	private double					shopLon;
	private String					shopName;
	private int						shopRestock;
	private List<ShopItem>			shopItems;
	private List<ShopUpgrade>		shopUpgrades;
	public Map<String, ShopItem>	shopItemsMap;
	public Map<String, ShopUpgrade>	shopUpgradesMap;

	public Shop(double shopLat, double shopLon, String shopName, int shopRestock,
		List<ShopItem> shopItems, List<ShopUpgrade> shopUpgrades)
	{
		this.shopLat = shopLat;
		this.shopLon = shopLon;
		this.shopName = shopName;
		this.shopRestock = shopRestock;
		this.shopItems = shopItems;
		this.shopItemsMap = new HashMap<>();
		this.shopUpgradesMap = new HashMap<>();
		addShopItemsToMap();
		addShopUpgradesToMap();
	}

	public Map<String, ShopItem> getShopItemsMap()
	{
		return shopItemsMap;
	}

	public void setShopItemsMap(Map<String, ShopItem> ShopItemsMap)
	{
		this.shopItemsMap = ShopItemsMap;
	}

	public double getShopLat()
	{
		return shopLat;
	}

	public void setShopLat(double shopLat)
	{
		this.shopLat = shopLat;
	}

	public double getShopLon()
	{
		return shopLon;
	}

	public void setShopLon(double shopLon)
	{
		this.shopLon = shopLon;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public int getShopRestock()
	{
		return shopRestock;
	}

	public void setShopRestock(int shopRestock)
	{
		this.shopRestock = shopRestock;
	}

	public List<ShopItem> getShopItems()
	{
		return shopItems;
	}

	public void setShopItems(List<ShopItem> shopItems)
	{
		this.shopItems = shopItems;
	}

	public List<ShopUpgrade> getShopUpgrades()
	{
		return shopUpgrades;
	}

	public void setShopUpgrades(List<ShopUpgrade> shopUpgrades)
	{
		this.shopUpgrades = shopUpgrades;
	}

	public void addShopItemsToMap()
	{
		for (ShopItem item : this.shopItems)
			shopItemsMap.putIfAbsent(item.getName(), item);
	}

	public void addShopUpgradesToMap()
	{
		for (ShopUpgrade upgrade : this.shopUpgrades)
			this.shopUpgradesMap.putIfAbsent(upgrade.getName(), upgrade);
	}

}
