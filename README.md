# java_oop_project

Sample Output of ReadExcel Class

```
[I/o, Field Name, Type, Allowed Values, Mandatory]
[I, /object1, object1, , Y]
[I, /object1/field1, string, , Y]
[I, /object1/field2, string, , Y]
[I, /object1/field3, string, , Y]
[I, /object1/field4, string, , N]
[I, /object1/object2, object2, , Y]
[I, /object1/object2/field5, string, 1,2,3, N]
[I, /object1/object2/field6, string, Y,N, N]
[I, /object1/object2/field7, string, , N]
[I, /object1/object2/field8, string, , N]
[I, /object1/object2/field9, string, , N]
[I, /object1/object2/field10, string, , Y]
[I, /object1/object2/field11, string, 0,1, Y]
[I, /field12, string, , Y]
[O, /object3, object3, , Y]
[O, /object3/field12, string, , Y]
[O, /object3/object4, object4, , Y]
[O, /object3/object4/field13, string, , Y]
[O, /object3/object4/field14, string, , Y]
[O, /object5, object5, , N]
[O, /object5/field15, string, , Y]
```

Sample Output of ArrangeData Class

```
[object1=I, field1=I, field2=I, field3=I, field4=I, object2=I, field5=I, field6=I, field7=I, field8=I, field9=I, field10=I, field11=I, field12=I, object3=O, field12=O, object4=O, field13=O, field14=O, object5=O, field15=O]

[field1, field2, field3, field4, object2]
[field5, field6, field7, field8, field9, field10, field11]
[field12, object4]
[field13, field14]
[field15]

[object1=No Restriction, field1=No Restriction, field2=No Restriction, field3=No Restriction, field4=No Restriction, object2=No Restriction, field5=1,2,3, field6=Y,N, field7=No Restriction, field8=No Restriction, field9=No Restriction, field10=No Restriction, field11=0,1, field12=No Restriction, object3=No Restriction, field12=No Restriction, object4=No Restriction, field13=No Restriction, field14=No Restriction, object5=No Restriction, field15=No Restriction]

[object1=Y, field1=Y, field2=Y, field3=Y, field4=N, object2=Y, field5=N, field6=N, field7=N, field8=N, field9=N, field10=Y, field11=Y, field12=Y, object3=Y, field12=Y, object4=Y, field13=Y, field14=Y, object5=N, field15=Y]

```
