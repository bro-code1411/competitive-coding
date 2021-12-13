package lld;

public class Elevator {
}

/*

LiftService
MapOfLifts

LiftToLevels<Lift, List<Levels>>

levels
Map<level, Lift<>>

1, lf1
2, lf2, lf4
3,
4,
5,lf3

3 up,

lift <Level>

Lift:
ListOfLevel 2 , 3
Direction null
State Full, Alarm, Good
CheckFeasibility(level, direction)



API:
Lift callLift(int level, Direction direction)
goToLevel( Lift lift, int level)
updateStateOfLift(Lift lift, level level)


 */