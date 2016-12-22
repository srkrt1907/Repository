using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Kruskal.Entities
{
    internal class Key : IComparable
    {
        IComparable element;

        public Key(IComparable element)
        {
            this.element = element;
        }

        public object Element
        {
            get { return (object)element; }
            set { element = (IComparable)value; }
        }

        public int CompareTo(object obj)
        {
            Key other = (Key)obj;
            return element.CompareTo(other.Element);
        }

        public override string ToString()
        {
            return element.ToString();
        }


    }
}
