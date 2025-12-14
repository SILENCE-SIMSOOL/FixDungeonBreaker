<p align="center">
	<a href="https://github.com/SILENCE-SIMSOOL/FixDungeonBreaker/releases" target="_blank">
		<img alt="release" src="https://img.shields.io/github/v/release/SILENCE-SIMSOOL/FixDungeonBreaker?color=E0E0E0&style=flat-square" />
	</a>
	<a href="https://github.com/SILENCE-SIMSOOL/FixDungeonBreaker/releases" target="_blank">
		<img alt="downloads" src="https://img.shields.io/github/downloads/SILENCE-SIMSOOL/FixDungeonBreaker/total?color=8b4db6&style=flat-square" />
	</a>
	<a href="https://discord.gg/2Zt8HDksJs" target="_blank">
		<img alt="discord" src="https://img.shields.io/discord/1312525891225784421?color=5865F2&label=discord&style=flat-square" />
	</a>
</p>

# 픽스 던전브레이커  
[픽스 던전브레이커](https://github.com/SILENCE-SIMSOOL/FixDungeonBreaker) 는 `1.8.9` 버전의 **마인크래프트 포지 모드** 입니다.  
이 모드는 하이픽셀 스카이블럭에서 `DungeonBreaker` 아이템을 핑이 높은 환경에서 사용할 때 불공정한 부분을 해결해줍니다.  

이 기능은 [SilenceUtils](https://github.com/SILENCE-SIMSOOL/SilenceUtils) 에 내장되어 있습니다.  
SilenceUtils를 사용하지 않거나 단순히 작동 방식을 이해하는데 관심이 있는 분들을 위해 별도로 제작되었습니다.  

## 던전 브레이커의 문제점
이 문제점은 핑이 낮거나 `1.20+` 과 같은 최신 버전을 사용할 땐 발생하지 않습니다.  

만약 플레이어의 핑이 높다면 던전브레이커의 사용을 서버한테 보내고 서버로부터 블럭이 캐졌다는 응답을 받을 때까지 상당한 시간이 소요됩니다.  
하지만 클라이언트에서는 핑과 상관없이 자체적으로 연산하여 블럭을 캐며 나중에 서버로부터 응답을 받습니다.  
클라이언트가 블럭을 캤을 때 서버로부터 부술 수 없는 블럭이라도 응답이 오면 블럭이 다시 생성되고 아니라면 블럭이 다시 생기지 않습니다.  
이러한 이유로 던전브레이커는 곡괭이이기 때문에 돌 유형 블럭들은 핑에 영향을 받지 않지만 그러지 못한 블럭들은 모두 핑만큼 딜레이가 생깁니다.

최신 버전의 마인크래프트(1.20+)에서는 아이템 태그 범위가 더 발전하여 던전브레이커가 모든 블록 유형에 대해 '1024f'의 채굴 속도를 가지도록 되어있습니다.  
**그러나 1.8.9**에서는 이 시스템이 존재하지 않으며, 그 효과는 **돌 유형** 블록에만 적용됩니다.  
더 나쁜 것은 **기본 채굴 속도**가 상당히 낮기 때문에 플레이어가 'onGround (땅에 서있지 않고 공중에 있는 상태)'가 아니면 한 틱으로 블록을 캘 수 없다는 것입니다.

예를 들어, '200ms' 핑이 있고 10칸 아래로 블록을 캔다면, 캐는데 '(200ms × 10) = 2'초나 걸릴 것입니다.

## 어떻게 해결했나요?
이 문제는 `1.20+` 버전 방식과 동일하게 **던전 브레이커**의 모든 블럭에 대한 **채굴 속도**를 `1024f`로 설정하여 해결했습니다.
```java
@SubscribeEvent
public void onBreakSpeed(PlayerEvent.BreakSpeed event) {
    if (ItemUtils.getItemID(item).equals("DUNGEONBREAKER")) {
        event.newSpeed = 1024.0F;
    }
}
```
## 어떻게 다운로드 하나요?
[여기에서](https://github.com/SILENCE-SIMSOOL/FixDungeonBreaker/releases/download/1.0.1/FixDungeonBreaker-1.0.1-mc1.8.9.jar) 다운로드 할 수 있습니다!  
