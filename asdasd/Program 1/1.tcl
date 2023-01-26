set ns [ new Simulator ]
set tf [ open 1.tr w ]
$ns trace-all $tf
set nf [ open 1.nam w ]
$ns namtrace-all $nf

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

$ns duplex-link $n0 $n2 10Mb 300ms DropTail
$ns duplex-link $n1 $n2 5Mb 200ms DropTail

$ns set queue-limit $n0 $n2 10
$ns set queue-limit $n1 $n2 5

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize _500
$cbr0 set interval _0.005
$cbr0 attach-agent $udp0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
set cbr1 [new Application/Traffic/CBR]
$cbr1 attach-agent $udp1

set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2
set cbr2 [new Application/Traffic/CBR]
$cbr2 attach-agent $udp2

set null0 [new Agent/Null]
$ns attach-agent $n2 $null0
$ns connect $udp0 $null0
$ns connect $udp1 $null0

proc finish { } {
global ns nf tf
$ns flush-trace
exec nam 1.nam &
close $tf
close $nf
exit 0
}

$ns at 0.1 "$cbr0 start"
$ns at 0.1 "$cbr1 start"
$ns at 1.0 "finish"
$ns run
