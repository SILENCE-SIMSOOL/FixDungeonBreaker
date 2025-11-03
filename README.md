## Fix DungeonBreaker
[Fix DungeonBreaker](https://github.com/SILENCE-SIMSOOL/FixDungeonBreaker) is a **Minecraft Forge mod** for version `1.8.9`.
It fixes the unfair issues that occur when using the `DungeonBreaker` item in Hypixel SkyBlock caused by high ping.

## Problem with DungeonBreaker
This issue doesn’t occur for players with low ping or in newer versions `1.20+`.

When you have high ping, block breaking is delayed because the server needs to verify each block before confirming that it’s broken.
The client breaks the block immediately, but if the server responds that the block wasn’t actually breakable, the block reappears.

In modern versions of Minecraft (1.20+), item tag ranges are more advanced, allowing the DungeonBreaker to have a mining speed of `1024f` for all block types.
**However, in 1.8.9**, this system doesn’t exist since the **DungeonBreaker is technically a pickaxe**, its effect only applies to **stone-type** blocks.
Worse, the **base mining speed is quite low**, so unless the player is `onGround`, it can’t break blocks in a single tick.

For example, if you have `200ms` ping and you’re breaking blocks 10 blocks straight down, it will take `(200ms × 10) = 2` seconds just to descend.
