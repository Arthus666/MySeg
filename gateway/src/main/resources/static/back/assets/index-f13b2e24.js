import{w as p,u as M,_ as a,a as d,f as S}from"./default-d6449ec9.js";import{v as w,y as r,f as s}from"./index-1e170dd9.js";var P=function(){return{prefixCls:String,type:{type:String,default:"horizontal"},dashed:{type:Boolean,default:!1},orientation:{type:String,default:"center"},plain:{type:Boolean,default:!1},orientationMargin:[String,Number]}},b=w({compatConfig:{MODE:3},name:"ADivider",props:P(),setup:function(n,g){var l=g.slots,u=M("divider",n),o=u.prefixCls,h=u.direction,c=r(function(){return n.orientation==="left"&&n.orientationMargin!=null}),f=r(function(){return n.orientation==="right"&&n.orientationMargin!=null}),m=r(function(){var t,i=n.type,C=n.dashed,_=n.plain,e=o.value;return t={},a(t,e,!0),a(t,"".concat(e,"-").concat(i),!0),a(t,"".concat(e,"-dashed"),!!C),a(t,"".concat(e,"-plain"),!!_),a(t,"".concat(e,"-rtl"),h.value==="rtl"),a(t,"".concat(e,"-no-default-orientation-margin-left"),c.value),a(t,"".concat(e,"-no-default-orientation-margin-right"),f.value),t}),y=r(function(){var t=typeof n.orientationMargin=="number"?"".concat(n.orientationMargin,"px"):n.orientationMargin;return d(d({},c.value&&{marginLeft:t}),f.value&&{marginRight:t})}),x=r(function(){return n.orientation.length>0?"-"+n.orientation:n.orientation});return function(){var t,i=S((t=l.default)===null||t===void 0?void 0:t.call(l));return s("div",{class:[m.value,i.length?"".concat(o.value,"-with-text ").concat(o.value,"-with-text").concat(x.value):""],role:"separator"},[i.length?s("span",{class:"".concat(o.value,"-inner-text"),style:y.value},[i]):null])}}});const I=p(b);export{I as _};