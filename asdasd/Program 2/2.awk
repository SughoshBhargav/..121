BEGIN{
drop = 0;
rec = 0;
}
{
if($1 == "$d")
{
drop++;
}
if($1 == "$r")
{
rec++;
}
}
END{
printf("Total number of %s packets dropped due to congestion is %d\n", $5, drop);
printf("Total number of %s packets recieved due to congestion is %d\n", $5, rec);
}
