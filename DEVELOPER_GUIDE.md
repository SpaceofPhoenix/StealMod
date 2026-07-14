# Steel Mod Developer Guide

Quick reference guide for developers working with the Steel Mod codebase.

## Project Structure

```
StealMod/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── TemplateMod.java              # Main mod entry point
│   │   │   ├── item/ModItems.java             # Item definitions
│   │   │   ├── block/ModBlocks.java           # Block definitions
│   │   │   ├── material/ModToolMaterials.java # Material stats
│   │   │   ├── recipe/ModRecipes.java         # Recipe logic
│   │   │   ├── datagen/
│   │   │   │   ├── ModRecipeProvider.java     # Recipe generation
│   │   │   │   ├── ModModelProvider.java      # Model generation
│   │   │   │   └── ModBlockLootTableProvider.java
│   │   │   └── mixin/                         # Behavior modifications
│   │   └── resources/
│   │       ├── assets/template-mod/
│   │       │   ├── lang/en_us.json
│   │       │   ├── textures/
│   │       │   └── models/
│   │       └── data/minecraft/tags/
│   ├── client/
│   │   └── java/com/example/client/
│   │       └── TemplateModDataGenerator.java  # Data gen entry point
│   └── test/
├── build.gradle
├── gradle.properties
└── [documentation files]
```

## Adding New Items

1. **Define the item** in `ModItems.java`:
```java
public static final Item NEW_ITEM = registerItem("new_item",
    new Item(new Item.Settings()));
```

2. **Add translation** in `en_us.json`:
```json
"item.template-mod.new_item": "New Item Name"
```

3. **Add texture** in `src/main/resources/assets/template-mod/textures/item/new_item.png`

4. The model provider will automatically generate the JSON model file.

## Adding New Blocks

1. **Define the block** in `ModBlocks.java`:
```java
public static final Block NEW_BLOCK = registerBlock("new_block",
    new Block(AbstractBlock.Settings.create()
        .strength(2.0f, 2.0f)
        .sounds(BlockSoundGroup.STONE)));
```

2. **Add translation** in `en_us.json`:
```json
"block.template-mod.new_block": "New Block Name"
```

3. **Add textures** in `src/main/resources/assets/template-mod/textures/block/new_block.png`

4. Block state and model generation happens automatically.

## Adding New Recipes

1. **Add recipe** in `ModRecipeProvider.java` under the `generate()` method:
```java
createShapedRecipe(OUTPUT_ITEM)
    .input('M', INPUT_ITEM)
    .pattern("MMM")
    .pattern("MMM")
    .pattern("MMM")
    .criterion(hasItem(INPUT_ITEM), conditionsFromItem(INPUT_ITEM))
    .offerTo(exporter);
```

2. Run data generation: `./gradlew runDatagen`

3. The JSON recipe file is automatically created.

## Tool/Armor Material Reference

### Tool Material Properties (in ModToolMaterials.java)
- `getDurability()` - Number of uses before breaking
- `getMiningSpeedMultiplier()` - How fast blocks are broken
- `getAttackDamage()` - Bonus damage for tools
- `getMiningLevel()` - What blocks can be mined:
  - 0: Stone, coal, wood
  - 1: Iron, gold, lapis, redstone
  - 2: Diamond, obsidian (steel is level 2 but overridden)
  - 3: Obsidian only
- `getEnchantability()` - How easy to enchant
- `getRepairIngredient()` - What item repairs this tool

### Armor Material Properties (in ModToolMaterials.java)
- Protection values array: `[helmet, chestplate, leggings, boots]`
- Enchantability: How easy to enchant
- Toughness: Reduces damage from critical hits
- Knockback resistance: Resistance to knockback

## Data Generation

Run data generation to create all JSON files:
```bash
./gradlew runDatagen
```

This generates:
- Recipe JSON files in `generated/data/template-mod/recipes/`
- Model JSON files in `generated/resources/assets/template-mod/models/`
- Loot table JSON files in `generated/data/template-mod/loot_tables/`

## Common Tasks

### Change Tool Stats
1. Edit durability/speed in `ModToolMaterials.STEEL`
2. Update documentation in `STEEL_MOD_DOCUMENTATION.md`
3. Rebuild: `./gradlew build`

### Change Armor Stats
1. Edit protection values or toughness in `ModToolMaterials.STEEL_ARMOR_MATERIAL`
2. Update documentation
3. Rebuild

### Add New Language (Localization)
1. Create `en_gb.json`, `fr_fr.json`, etc. in `assets/template-mod/lang/`
2. Add translations for all items and blocks
3. Rebuild

### Modify Crafting Recipes
1. Edit shapes in `ModRecipeProvider.java`
2. Run data generation: `./gradlew runDatagen`
3. Verify recipes in game: `./gradlew runClient`

## Mixin Guide

Mixins modify Minecraft's bytecode without replacing entire classes.

### Existing Mixins
- `SteelItemMixin` - Item fire-resistance behavior
- `SteelArmorMixin` - Armor fire resistance calculations
- `SteelBlockExplosionMixin` - Block explosion immunity

### Adding a Mixin
1. Create new mixin class in `com.example.mixin`
2. Add `@Mixin(TargetClass.class)` annotation
3. Add injection methods with `@Inject` annotation
4. Register in `template-mod.mixins.json`

Example:
```java
@Mixin(Entity.class)
public class MyMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo ci) {
        // Code runs at start of tick method
    }
}
```

## Building & Testing

### Build JAR
```bash
./gradlew build
# Output: build/libs/template-mod-1.0.jar
```

### Test in Client
```bash
./gradlew runClient
```

### Test on Server
```bash
./gradlew runServer
```

### Clean Build
```bash
./gradlew clean build
```

## Common Issues

### "Cannot find symbol"
- Make sure all classes are properly imported
- Check class names match file names
- Verify package declarations match file structure

### Data not generating
- Run `./gradlew runDatagen`
- Check output in `build/generated/`
- Verify providers are registered in `TemplateModDataGenerator.java`

### Textures not loading
- Ensure PNG files are 16x16
- Place in correct `textures/item/` or `textures/block/` directory
- Rebuild with `./gradlew build`

### Models missing
- Run data generation: `./gradlew runDatagen`
- Check generated JSON in `build/generated/`
- Model provider should auto-generate for registered items

## Useful Links

- [Fabric Documentation](https://fabricmc.net/)
- [Minecraft Data Generators](https://docs.fabricmc.net/develop/datagen)
- [Mixin Documentation](https://github.com/SpongePowered/Mixin/wiki)
- [Minecraft Wiki](https://minecraft.wiki/)

## Version Info

- Minecraft: 26.2
- Java: 25+
- Fabric API: Latest
- Loom: Latest

## MOD_ID Reference
`template-mod` - Used as namespace prefix for all items and blocks
