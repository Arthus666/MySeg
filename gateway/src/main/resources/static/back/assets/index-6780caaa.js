import{u as x,c as D,M as n,_ as m,a as f}from"./Menu-7d70b547.js";import{x as j,a as v,P as y,u as G,_}from"./default-d6449ec9.js";import{v as C,y as g,f as i}from"./index-1e170dd9.js";var h=function(){return{title:y.any}};const p=C({compatConfig:{MODE:3},name:"AMenuItemGroup",inheritAttrs:!1,props:h(),slots:["title"],setup:function(o,u){var t=u.slots,s=u.attrs,r=x(),M=r.prefixCls,a=g(function(){return"".concat(M.value,"-item-group")}),I=D();return function(){var l,c;return I?(l=t.default)===null||l===void 0?void 0:l.call(t):i("li",v(v({},s),{},{onClick:function(P){return P.stopPropagation()},class:a.value}),[i("div",{title:typeof o.title=="string"?o.title:void 0,class:"".concat(a.value,"-title")},[j(t,o,"title")]),i("ul",{class:"".concat(a.value,"-list")},[(c=t.default)===null||c===void 0?void 0:c.call(t)])])}}});var S=function(){return{prefixCls:String,dashed:Boolean}};const d=C({compatConfig:{MODE:3},name:"AMenuDivider",props:S(),setup:function(o){var u=G("menu",o),t=u.prefixCls,s=g(function(){var r;return r={},_(r,"".concat(t.value,"-item-divider"),!0),_(r,"".concat(t.value,"-item-divider-dashed"),!!o.dashed),r});return function(){return i("li",{class:s.value},null)}}});n.install=function(e){return e.component(n.name,n),e.component(m.name,m),e.component(f.name,f),e.component(d.name,d),e.component(p.name,p),e};n.Item=m;n.Divider=d;n.SubMenu=f;n.ItemGroup=p;