import{u as D,j as V,x as X,_ as s,a as S,P as $}from"./default-d6449ec9.js";import{u as q,e as G}from"./eagerComputed-6d64a5a5.js";import{r as J}from"./responsiveObserve-32929795.js";import{R as K}from"./collapseMotion-aa2d52e7.js";import{u as Q}from"./useSize-f4b45b31.js";import{v as U,a as f,y as Y,A as j,I as C,o as Z,f as d}from"./index-1e170dd9.js";var ee=function(){return{prefixCls:String,shape:{type:String,default:"circle"},size:{type:[Number,String,Object],default:function(){return"default"}},src:String,srcset:String,icon:$.any,alt:String,gap:Number,draggable:{type:Boolean,default:void 0},crossOrigin:String,loadError:{type:Function}}},ae=U({compatConfig:{MODE:3},name:"AAvatar",inheritAttrs:!1,props:ee(),slots:["icon"],setup:function(e,A){var y=A.slots,g=A.attrs,m=f(!0),E=f(!1),p=f(1),h=f(null),x=f(null),_=D("avatar",e),O=_.prefixCls,R=Q(),n=Y(function(){return e.size==="default"?R.value:e.size}),T=q(),o=G(function(){if(V(e.size)==="object"){var r=J.find(function(t){return T.value[t]}),a=e.size[r];return a}}),W=function(a){return o.value?{width:"".concat(o.value,"px"),height:"".concat(o.value,"px"),lineHeight:"".concat(o.value,"px"),fontSize:"".concat(a?o.value/2:18,"px")}:{}},z=function(){if(!(!h.value||!x.value)){var a=h.value.offsetWidth,t=x.value.offsetWidth;if(a!==0&&t!==0){var l=e.gap,c=l===void 0?4:l;c*2<t&&(p.value=t-c*2<a?(t-c*2)/a:1)}}},k=function(){var a=e.loadError,t=a==null?void 0:a();t!==!1&&(m.value=!1)};return j(function(){return e.src},function(){C(function(){m.value=!0,p.value=1})}),j(function(){return e.gap},function(){C(function(){z()})}),Z(function(){C(function(){z(),E.value=!0})}),function(){var r,a,t=e.shape,l=e.src,c=e.alt,N=e.srcset,w=e.draggable,B=e.crossOrigin,u=X(y,e,"icon"),i=O.value,H=(r={},s(r,"".concat(g.class),!!g.class),s(r,i,!0),s(r,"".concat(i,"-lg"),n.value==="large"),s(r,"".concat(i,"-sm"),n.value==="small"),s(r,"".concat(i,"-").concat(t),t),s(r,"".concat(i,"-image"),l&&m.value),s(r,"".concat(i,"-icon"),u),r),M=typeof n.value=="number"?{width:"".concat(n.value,"px"),height:"".concat(n.value,"px"),lineHeight:"".concat(n.value,"px"),fontSize:u?"".concat(n.value/2,"px"):"18px"}:{},P=(a=y.default)===null||a===void 0?void 0:a.call(y),v;if(l&&m.value)v=d("img",{draggable:w,src:l,srcset:N,onError:k,alt:c,crossorigin:B},null);else if(u)v=u;else if(E.value||p.value!==1){var b="scale(".concat(p.value,") translateX(-50%)"),F={msTransform:b,WebkitTransform:b,transform:b},L=typeof n.value=="number"?{lineHeight:"".concat(n.value,"px")}:{};v=d(K,{onResize:z},{default:function(){return[d("span",{class:"".concat(i,"-string"),ref:h,style:S(S({},L),F)},[P])]}})}else v=d("span",{class:"".concat(i,"-string"),ref:h,style:{opacity:0}},[P]);return d("span",S(S({},g),{},{ref:x,class:H,style:[M,W(!!u),g.style]}),[v])}}});const ce=ae;export{ce as A};
